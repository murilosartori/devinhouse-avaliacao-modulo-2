package br.com.devinhouse.projeto4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.service.ProcessoService;

//TODO 5 - Deverá haver um endpoint para atualização de todos os atributos de um processo baseado na sua identificação única (id);
//TODO 6 - Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (id); 

@RestController
@RequestMapping(value = "/v1/processos")
@ResponseBody
public class ProcessoController {
	@Autowired
	private ProcessoService service;
	
	@GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> listarTodosProcessos() {
		return service.listarTodosProcessos();
	}
	
	@GetMapping(value = "/consultar/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> listarProcessoId(@PathVariable Integer id) {
		return service.listarProcessoId(id);
	}
	
	@GetMapping(value = "/consultar/chave", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> listarProcessoChaveProcesso(@RequestParam String chaveProcesso) {
		return service.listarProcessoChave(chaveProcesso);
	}
	
	@PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> cadastrarProcesso(@RequestBody ProcessoDTO processo) {
		return service.cadastrarProcesso(processo);
	}
	
	@PutMapping(value = "/alterar/id/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> alterarProcesso(@RequestBody ProcessoDTO processo, @PathVariable Integer id) {
		return service.alterarProcesso(processo, id);
	}
	
	@DeleteMapping(value = "/excluir/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> excluirProcesso(@PathVariable Integer id) {
		return service.excluirProcesso(id);
	}
}
