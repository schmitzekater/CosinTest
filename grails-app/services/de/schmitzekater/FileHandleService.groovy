package de.schmitzekater

import grails.transaction.Transactional

import javax.servlet.http.HttpServletResponse
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class FileHandleService {
    def applicationConfigService
    MultipartFile file
    String originalFilename = ""

    /**
     *
     * @param request the request that contains the MultipartFile to be uploaded
     * @param obj the object where the qualification belongs to
     * @param qualificationDate the date of the qualification where the file belongs to
     * @return the path of the file (from uploadFile())
     */
    def uploadQualificationFile(MultipartHttpServletRequest request,QualifiableObject obj, Date qualificationDate) {
        // Store the files in yearly folders separated by Type
        String type = "dummy"
        String name = "nameDummy"
        if      (obj instanceof Module) type = 'Modules'
        else if (obj instanceof Software)   type = 'Software'
        name = obj.getDisplayString()
        def baseDir = applicationConfigService.uploadDir + applicationConfigService.qualificationDir
        String year = qualificationDate.format('YYYY')
        String month= qualificationDate.format('MM')
        File typeFolder             = new File (baseDir, type)
        if(!typeFolder.exists())    typeFolder.mkdir()
        File nameFolder             = new File (typeFolder, name)
        if(!nameFolder.exists())    nameFolder.mkdir()
        File yearFolder             = new File(nameFolder, year)
        if(!yearFolder.exists())    yearFolder.mkdir()
        File monthFolder            = new File (yearFolder, month)
        if(!monthFolder.exists())   monthFolder.mkdir()
        return uploadFile(request, 'attachment', monthFolder.absolutePath)
    }
    /**
     *
     * @param request the request that contains the MultipartFile to be uploaded
     * @param name Type of file (sent from the GSP as param)
     * @param targetDir Directory where the file is stored on the server
     * @return filename including the absolut path.
     */
    private def uploadFile(MultipartHttpServletRequest request, String name, String targetDir) {
        try {
            file = request.getFile(name)
            originalFilename = file.getOriginalFilename()
            log.info("Got file $file, originalName: $originalFilename")
            File fileDest = new File(targetDir, originalFilename)
            log.info("Dest: $fileDest.absolutePath")
            if(fileDest.exists()) {
                throw new FileExistsException(message: 'File exists', existingFile: fileDest)
            }
            file.transferTo(fileDest)
            return fileDest
        }
        catch (Exception e) {
            log.error(e.message, e.cause)
        }
    }
    /**
     *
     * @param request the request that contains the MultipartFile to be uploaded
     * @param system The system that own the dataflow file. Needed to create a specific upload-directory for that system
     * @return the path of the file (from uploadFile())
     */
    def uploadDataflowFile(MultipartHttpServletRequest request, System system) {
        // Store the files in System-specific upload-folders.
        def baseDir = applicationConfigService.uploadDir + applicationConfigService.dataflowDir
        File systemFolder = new File(baseDir, system.systemName)
        if (!systemFolder.exists()) systemFolder.mkdirs()
        return uploadFile(request, 'dataflow', systemFolder.absolutePath)
    }

    def deleteDataflowFile(File file) {
        return file.delete()
    }

    /**
     *
     * @param response the response sent from the controller (CommonController)
     * @param name the name of the file to be displayed as filename for the download
     * @param path the path of the file on the server for download
     * @return renders the file for download.
     */
    def downloadFile(HttpServletResponse response, String name, String path) {
        response.setContentType("APPLICATION/OCTET-STREAM")
        response.setHeader("Content-Disposition", "Attachment;Filename=\"${name}\"")
        def file = new File(path)
        def fileInputStream = new FileInputStream(file)
        def outputStream = response.getOutputStream()
        byte[] buffer = new byte[4096];
        int len;
        while ((len = fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.flush()
        outputStream.close()
        fileInputStream.close()

    }

}

class FileExistsException extends RuntimeException{
    String message
    File existingFile
}
