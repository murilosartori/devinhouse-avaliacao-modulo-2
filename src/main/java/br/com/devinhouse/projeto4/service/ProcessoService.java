package br.com.devinhouse.projeto4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.projeto4.dto.ProcessoDTO;
import br.com.devinhouse.projeto4.repository.ProcessoRepository;

@Service
public class ProcessoService {
	@Autowired
	private ProcessoRepository repository;

	public List<ProcessoDTO> listarTodosProcessos() {
		return repository.findAllProcessos();
	}

	public List<ProcessoDTO> listarProcessoId(Integer id) {
		List<ProcessoDTO> findAllProcessos = repository.findAllProcessos();
		List<ProcessoDTO> findProcessoFiltrado = new ArrayList<ProcessoDTO>();
		for (ProcessoDTO processo : findAllProcessos) {
			if (processo.getId() == id) {
				findProcessoFiltrado.add(processo);
				break;
			}
		}
		return findProcessoFiltrado;
	}

	public List<ProcessoDTO> listarProcessoChave(String chaveProcesso) {
		List<ProcessoDTO> findAllProcessos = repository.findAllProcessos();
		List<ProcessoDTO> findProcessoFiltrado = new ArrayList<ProcessoDTO>();
		for (ProcessoDTO processo : findAllProcessos) {
			if (processo.getChaveProcesso().toLowerCase().indexOf(chaveProcesso.toLowerCase()) >= 0) {
				findProcessoFiltrado.add(processo);
			}
		}
		return findProcessoFiltrado;
	}

	public List<ProcessoDTO> cadastrarProcesso(ProcessoDTO processo) {
		List<ProcessoDTO> findAllProcessos = repository.findAllProcessos();
		processo.setId(ProcessoDTO.getCountProcessoId());
		findAllProcessos.add(processo);
		return findAllProcessos;
	}

	public List<ProcessoDTO> alterarProcesso(ProcessoDTO processo, Integer id) {
		List<ProcessoDTO> findAllProcessos = repository.findAllProcessos();
		for (ProcessoDTO processoFind : findAllProcessos) {
			if (processoFind.getId() == id) {
				if (processo.getNuProcesso() != null) {
					processoFind.setNuProcesso(processo.getNuProcesso());
				}
				if (!processo.getChaveProcesso().isEmpty()) {
					processoFind.setChaveProcesso(processo.getChaveProcesso());
				}
				if (!processo.getSgOrgaoProcesso().isEmpty()) {
					processoFind.setSgOrgaoProcesso(processo.getSgOrgaoProcesso());
				}
				if (!processo.getNuAnoProcesso().isEmpty()) {
					processoFind.setNuAnoProcesso(processo.getNuAnoProcesso());
				}
				if (!processo.getDescricao().isEmpty()) {
					processoFind.setDescricao(processo.getDescricao());
				}
				if (processo.getCdAssunto() != null) {
					processoFind.setCdAssunto(processo.getCdAssunto());
				}
				if (!processo.getDescricaoAssunto().isEmpty()) {
					processoFind.setDescricaoAssunto(processo.getDescricaoAssunto());
				}
				if (processo.getCdInteressado() != null) {
					processoFind.setCdInteressado(processo.getCdInteressado());
				}
				if (!processo.getNmInteressado().isEmpty()) {
					processoFind.setNmInteressado(processo.getNmInteressado());
				}
				break;
			}
		}
		return findAllProcessos;
	}

	public List<ProcessoDTO> excluirProcesso(Integer id) {
		List<ProcessoDTO> findAllProcessos = repository.findAllProcessos();
		for (ProcessoDTO processo : findAllProcessos) {
			if (processo.getId() == id) {
				findAllProcessos.remove(processo);
				break;
			}
		}
		return findAllProcessos;
	}
}
