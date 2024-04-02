package com.cinefide.service;

import jakarta.mail.MessagingException;

public interface CorreoService {

    // la firma del metodo para enviar correos html
    public void enviarCorreoHtml(
            String para,
            String asunto,
            String contenidoHtml)
            throws MessagingException;
}
