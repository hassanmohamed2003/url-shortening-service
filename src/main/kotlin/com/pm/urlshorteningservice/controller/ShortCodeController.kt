package com.pm.urlshorteningservice.controller

import com.pm.urlshorteningservice.service.UrlService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
@RequestMapping
class ShortCodeController(private val urlService: UrlService) {

    @GetMapping("/{code}")
    fun redirect(@PathVariable code: String): RedirectView {
        val url = urlService.redirect(code)

        return RedirectView(url);
    }
}