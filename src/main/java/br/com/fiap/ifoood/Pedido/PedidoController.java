package br.com.fiap.ifoood.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pedidos", service.findAll());
        return "pedido/index"; // Este é o retorno que especifica o nome do template
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            redirect.addFlashAttribute("success", "Pedido apagado com sucesso");
        } else {
            redirect.addFlashAttribute("error", "Pedido não foi encontrada");
        }
        return "redirect:/pedido";
    }
}
