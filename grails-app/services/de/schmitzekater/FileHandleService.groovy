package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class FileHandleService {
    def servletContext
    MultipartFile file
    String originalFilename = ""

    // TODO: Check if directories exist!

    def serviceMethod() {

    }

    def uploadQualificationFile(MultipartHttpServletRequest request) {
        return uploadFile(request, 'attachment', '/uploads/qualifications')
    }

    private def uploadFile(MultipartHttpServletRequest request, String name, String targetDir) {
        try {
            file = request.getFile(name)
            originalFilename = file.getOriginalFilename()
            log.info("Got file $file, originalName: $originalFilename")
            def uploadDir = servletContext.getRealPath(targetDir)
            File fileDest = new File(uploadDir, originalFilename)
            log.info("Dest: $fileDest.absolutePath")
            file.transferTo(fileDest)
            return fileDest
        }
        catch (Exception e) {
            log.error(e.message, e.cause)
        }
    }

    def uploadDataflowFile(MultipartHttpServletRequest request) {
        return uploadFile(request, 'dataflow', '/uploads/dataflow')
    }


}
