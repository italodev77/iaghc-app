package com.dev.iagch.api.produtos.controller;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.application.produtos.dtos.ProdutoRequestDto;
import com.dev.iagch.application.produtos.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final CriarProdutoService criarService;
    private final AtualizarProdutoService atualizarService;
    private final DeletarProdutoService deletarService;
    private final BuscarProdutoPorIdService buscarPorIdService;
    private final ListarTodosProdutosService listarTodosService;

    @GetMapping
    public ResponseEntity<List<Produtos>> listarTodos() {
        return ResponseEntity.ok(listarTodosService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(buscarPorIdService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produtos> criarProduto(@RequestBody ProdutoRequestDto dto) {
        return ResponseEntity.ok(criarService.criarProduto(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDto dto) {
        return ResponseEntity.ok(atualizarService.atualizarProduto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        deletarService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
