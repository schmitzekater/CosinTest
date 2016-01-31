package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class FileHandleService {
    def servletContext
    MultipartFile file
    String originalFilename = ""


    def uploadQualificationFile(MultipartHttpServletRequest request,QualifiableObject obj, Date qualificationDate) {
        // Store the files in yearly folders separated by Type
        String type = "dummy"
        String name = "nameDummy"
        if      (obj instanceof Module) type = 'Modules'
        else if (obj instanceof Software)   type = 'Software'
        name = obj.getDisplayString()
        def baseDir = servletContext.getRealPath('/uploads/qualifications')
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

    def uploadDataflowFile(MultipartHttpServletRequest request, System system) {
        // Store the files in System-specific upload-folders.
        def baseDir = servletContext.getRealPath('/uploads/dataflow')
        File systemFolder = new File(baseDir, system.systemName)
        if(!systemFolder.exists()) systemFolder.mkdir()
        return uploadFile(request, 'dataflow', systemFolder.absolutePath)
    }

    def deleteDataflowFile(File file) {
        return file.delete()
    }

}

class FileExistsException extends RuntimeException{
    String message
    File existingFile
}
