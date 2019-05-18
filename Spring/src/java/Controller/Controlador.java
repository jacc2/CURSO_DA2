/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;


/**
 *
 * @author Administrador
 */

@Controller
public class Controlador {
    Conexion cnn = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(cnn.Conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "select * from persona";
        List datos=jdbcTemplate.queryForList(sql);
        mav.addObject("Listar",datos);
        mav.setViewName("index");
                return mav;
    }
}
