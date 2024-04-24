package com.cinefide.service.Impl;

import com.cinefide.dao.ReservasDao;
import com.cinefide.domain.ReservaConfirmacion;
import com.cinefide.domain.Reservas;
import com.cinefide.service.CorreoService;
import com.cinefide.service.ReservasService;
import com.cinefide.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas(boolean activo) {
        var lista = reservasDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Reservas reservas) {
        return reservasDao.findById(reservas.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }

    @Override
    public List<Reservas> getReservasByIdUsuario(Long IdUsuario) {
        var lista = reservasDao.findByIdUsuario(IdUsuario);
        return lista;
    }

    @Override
    public void notificar(ReservaConfirmacion reservasConfirmacion) throws MessagingException {
        System.out.println(reservasConfirmacion);
        updateEstado(reservasConfirmacion.gettIdReserva() , "pagado");
        String[] asientos = reservasConfirmacion.getTasientosPelicula().split("-");
        int cantBoletos = asientos.length;
        Random random = new Random();
        int codigoAleatorio = 1000000 + random.nextInt(9000000);
        String mensaje = "</head>\n"
                + " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n"
                + "  <div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"es\" style=\"background-color:#FAFAFA\"><!--[if gte mso 9]>\n"
                + "			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n"
                + "				<v:fill type=\"tile\" color=\"#fafafa\"></v:fill>\n"
                + "			</v:background>\n"
                + "		<![endif]-->\n"
                + "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#FAFAFA\">\n"
                + "     <tr>\n"
                + "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n"
                + "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n"
                + "         <tr>\n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\">\n"
                + "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0\"><h2 style=\"Margin:0;line-height:31px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:26px;font-style:normal;font-weight:bold;color:#333333\">CineFide</h2></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n"
                + "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td esdev-links-color=\"#ffffff\" align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:lora, georgia, 'times new roman', serif;line-height:23px;color:#000000;font-size:15px\"><em><span style=\"line-height:120%\">Tu mejor opción en Cines</span></em></p></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "           </table></td>\n"
                + "         </tr>\n"
                + "       </table>\n"
                + "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n"
                + "         <tr>\n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\">\n"
                + "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:15px;padding-left:20px;padding-right:20px\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;font-size:0px\"><img src=\"https://fhhzrmc.stripocdn.email/content/guids/CABINET_54100624d621728c49155116bef5e07d/images/84141618400759579.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"100\"></td>\n"
                + "                     </tr>\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h1 style=\"Margin:0;line-height:46px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:46px;font-style:normal;font-weight:bold;color:#333333\">Confirmación de compra</h1></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "           </table></td>\n"
                + "         </tr>\n"
                + "       </table>\n"
                + "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n"
                + "         <tr>\n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\">\n"
                + "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:20px;Margin:0\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0\"><h2 style=\"Margin:0;line-height:31px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:26px;font-style:normal;font-weight:bold;color:#333333\">Order&nbsp;<a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#5C68E2;font-size:26px\">#" + codigoAleatorio + "</a></h2></td>\n"
                + "                     </tr>\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" class=\"es-m-p0r es-m-p0l\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:40px;padding-right:40px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" + LocalDate.now() + "</p></td>\n"
                + "                     </tr>\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" class=\"es-m-p0r es-m-p0l\" style=\"Margin:0;padding-top:5px;padding-bottom:15px;padding-left:40px;padding-right:40px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Este e-mail es para confirmar tu compra en CineFide<br>se detalla abajo<br></p></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "             <tr>\n"
                + "              <td class=\"esdev-adapt-off\" align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"esdev-mso-table\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:560px\">\n"
                + "                 <tr>\n"
                + "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n"
                + "                     <tr>\n"
                + "                      <td class=\"es-m-p0r\" align=\"center\" style=\"padding:0;Margin:0;width:70px\">\n"
                + "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                         <tr>\n"
                + "                          <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://www.anahuac.mx/generacion-anahuac/sites/default/files/articles/SalaDeCine.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"70\"></td>\n"
                + "                         </tr>\n"
                + "                       </table></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                  <td style=\"padding:0;Margin:0;width:20px\"></td>\n"
                + "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;width:265px\">\n"
                + "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                         <tr>\n"
                + "                          <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>" + reservasConfirmacion.getTnombPelicula() + "</strong></p></td>\n"
                + "                         </tr>\n"
                + "                         <tr>\n"
                + "                          <td align=\"left\" style=\"padding:0;Margin:0;padding-top:5px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Asientos: " + reservasConfirmacion.getTasientosPelicula() + "<br>Horario: " + reservasConfirmacion.getThoraPelicula() + "</p></td>\n"
                + "                         </tr>\n"
                + "                       </table></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                  <td style=\"padding:0;Margin:0;width:20px\"></td>\n"
                + "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"left\" style=\"padding:0;Margin:0;width:80px\">\n"
                + "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                         <tr>\n"
                + "                          <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">" + cantBoletos + " Boletos</p></td>\n"
                + "                         </tr>\n"
                + "                       </table></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                  <td style=\"padding:0;Margin:0;width:20px\"></td>\n"
                + "                  <td class=\"esdev-mso-td\" valign=\"top\" style=\"padding:0;Margin:0\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"left\" style=\"padding:0;Margin:0;width:85px\">\n"
                + "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                         <tr>\n"
                + "                          <td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">¢ " + 3200 + "</p></td>\n"
                + "                         </tr>\n"
                + "                       </table></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:20px;padding-right:20px\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td class=\"es-m-p0r\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-top:2px solid #efefef;border-bottom:2px solid #efefef\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"right\" class=\"es-m-txt-r\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Total:&nbsp;<strong>¢ " + (cantBoletos * 3200) + ".00</strong></p></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:15px;padding-left:20px;padding-right:20px\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">Tienes consultas? contacto@cinefide.com o puedes llamarnos al 83894428</p></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "           </table></td>\n"
                + "         </tr>\n"
                + "       </table>\n"
                + "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n"
                + "         <tr>\n"
                + "          <td align=\"center\" style=\"padding:0;Margin:0\">\n"
                + "           <table class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:640px\">\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px;font-size:0\">\n"
                + "                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                         <tr>\n"
                + "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Facebook\" src=\"https://fhhzrmc.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n"
                + "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Twitter\" src=\"https://fhhzrmc.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n"
                + "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Instagram\" src=\"https://fhhzrmc.stripocdn.email/content/assets/img/social-icons/logo-black/instagram-logo-black.png\" alt=\"Inst\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n"
                + "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><img title=\"Youtube\" src=\"https://fhhzrmc.stripocdn.email/content/assets/img/social-icons/logo-black/youtube-logo-black.png\" alt=\"Yt\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n"
                + "                         </tr>\n"
                + "                       </table></td>\n"
                + "                     </tr>\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:35px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#333333;font-size:12px\">CineFide © 2024 Tu mejor opción de cines. Todos los derechos reservados.</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#333333;font-size:12px\">Del Colegio de Ingenieros y Arquitectos en Curridabat, 500 metros Norte y 300 metros al Este. Campus San Pedro, San José</p></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "           </table></td>\n"
                + "         </tr>\n"
                + "       </table>\n"
                + "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n"
                + "         <tr>\n"
                + "          <td class=\"es-info-area\" align=\"center\" style=\"padding:0;Margin:0\">\n"
                + "           <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" bgcolor=\"#FFFFFF\">\n"
                + "             <tr>\n"
                + "              <td align=\"left\" style=\"padding:20px;Margin:0\">\n"
                + "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                 <tr>\n"
                + "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n"
                + "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n"
                + "                     <tr>\n"
                + "                      <td align=\"center\" style=\"padding:0;Margin:0;display:none\"></td>\n"
                + "                     </tr>\n"
                + "                   </table></td>\n"
                + "                 </tr>\n"
                + "               </table></td>\n"
                + "             </tr>\n"
                + "           </table></td>\n"
                + "         </tr>\n"
                + "       </table></td>\n"
                + "     </tr>\n"
                + "   </table>\n"
                + "  </div>\n"
                + " </body>";
        String asunto = "Confirmacion de compra";
        correoService.enviarCorreoHtml("r.alejimenez@gmail.com", asunto, mensaje);
    }

    @Override
    @Transactional
    public void updateEstado(Long reservaId, String nuevoEstado) {
        Reservas reserva = reservasDao.findById(reservaId).orElse(null);

        if (reserva != null) {
            // Actualizar el estado
            reserva.setEstado(nuevoEstado);
            reservasDao.save(reserva);
        } else {
            // muestra errosr si hay error
            throw new RuntimeException("Reserva no encontrada para el ID: " + reservaId);
        }
    }
}
