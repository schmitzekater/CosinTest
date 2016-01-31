package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class FileHandleService {
    def servletContext

    def serviceMethod() {

    }

    def uploadQualificationFile(MultipartHttpServletRequest request){
        log.info("In uploadFile im FileHandleService")
        MultipartFile file
        String originalFilename = ""
        try{
            file = request.getFile('attachment')
            originalFilename = file.getOriginalFilename()
            log.info("Got file $file, orignialName: $originalFilename")

            def uploadDir = servletContext.getRealPath("/uploads/qualifications")
            File fileDest = new File(uploadDir,originalFilename)
            log.info("Dest: $fileDest.absolutePath")
            file.transferTo(fileDest)
            return fileDest
        }
        catch (Exception e){
            log.error(e.message, e.cause)
        }
    }
}
