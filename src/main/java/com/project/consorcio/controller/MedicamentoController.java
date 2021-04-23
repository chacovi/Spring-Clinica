package com.project.consorcio.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.service.MedicamentoService;
import com.project.consorcio.service.TipoMedicamentoService;

@Controller
@RequestMapping(value = "/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		try {
			//enviar atributo a la página "medicamento.html"
			model.addAttribute("medicamentos",medicamentoService.list());
			model.addAttribute("tipos",tipoMedicamentoService.listAll());
			model.addAttribute("medicamento",new Medicamento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicamento";
	}
	@RequestMapping(value = "/guardar")
	public String guardar(@ModelAttribute Medicamento medicamento,@RequestParam("tipo") int codTipo,
							@RequestParam("fecha") String fecha,RedirectAttributes redirect) {
		try {
			//crear un objeto de la clase TipoMedicamento
			TipoMedicamento tp=new TipoMedicamento();
			tp.setCodTipo(codTipo);
			//enviar objeto "tp" al objeto "medicamento"
			medicamento.setTbTipoMedicamento(tp);
			//
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			Date fec=sd.parse(fecha);
			medicamento.setFecFabMed(fec);
			//validar código
			if(medicamento.getCodMed()==0) {
				medicamentoService.save(medicamento);
				//mensaje
				redirect.addFlashAttribute("MENSAJE","Medicamento guardado");
			}
			else {
				medicamentoService.update(medicamento);
				//mensaje
				redirect.addFlashAttribute("MENSAJE","Medicamento actualizado");
			}
				
				
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error al guardar");
		}
		return "redirect:/medicamento/";
	}
	@RequestMapping(value = "/buscarMedicamento")
	@ResponseBody
	public Medicamento buscarMedicamento(@RequestParam("codMedi") int cod) {
		Medicamento med=null;
		try {
			med=medicamentoService.find(cod);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return med;
	}
	@RequestMapping(value = "/eliminarMedicamento")
	public String eliminar(@RequestParam("codMedi") int cod,RedirectAttributes redirect) {
		try {
			medicamentoService.delete(cod);
			redirect.addFlashAttribute("MENSAJE","Medicamento eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/medicamento/";
	}
}














