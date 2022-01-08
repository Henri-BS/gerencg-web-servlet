package com.altercode.dao;

import com.altercode.model.Categoria;
import com.altercode.model.UnidadeMedida;
import com.altercode.infra.ConnectionFactory;
import com.altercode.idao.ProdutoIDAO;
import com.altercode.model.Produto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO implements ProdutoIDAO {

    @Override
    public Produto save(Produto produto) {
        try (Connection con = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO Produto (id, descricao, quantidade, preco, validade, categoria, unidade_medida) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, produto.getId());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPreco());
            ps.setDate(5, java.sql.Date.valueOf(produto.getValidade()));
            ps.setString(6, produto.getCategoria().toString());
            ps.setString(7, produto.getMedida().toString());
            ps.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return produto;
    }

    @Override
    public Produto update(Produto produto) {
        try(Connection con = ConnectionFactory.getConnection()){
            String sql = "UPDATE Produto SET descricao = ?, quantidade = ?, preco = ?, validade = ?, categoria = ?, unidade_medida = ? WHERE id = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            ps.setDate(4, java.sql.Date.valueOf(produto.getValidade()));
            ps.setString(5, produto.getCategoria().toString());
            ps.setString(6, produto.getMedida().toString());
            ps.setLong(7, produto.getId());
            ps.executeUpdate();



        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return produto;
    }

    @Override
    public void delete(Long id) {
        try (Connection con = ConnectionFactory.getConnection()){

            String sql = "DELETE FROM Produto WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Produto> findAllProd() {
        String sql = "SELECT * FROM Produtos";
        List <Produto> produtos = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long pk = rs.getLong("id");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                LocalDate validade = rs.getDate("validade").toLocalDate();
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                UnidadeMedida medida = UnidadeMedida.valueOf(rs.getString("unidade_medida"));

                Produto produto = new Produto(pk, descricao, quantidade, preco, validade, categoria, medida);
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return produtos;
    }

    @Override
    public Optional<Produto> findById(Long id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        Produto produto = null;

        try (Connection con = ConnectionFactory.getConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long pk = rs.getLong("id");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                LocalDate validade = rs.getDate("validade").toLocalDate();
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                UnidadeMedida medida = UnidadeMedida.valueOf(rs.getString("unidade_medida"));

                produto = new Produto(pk, descricao, quantidade, preco, validade, categoria, medida);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(produto);
    }

    @Override
    public List<Produto> findByCat(Categoria categoria) {
        String sql = "SELECT * FROM Produto WHERE categoria = ?";
        List<Produto> produtos = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoria.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long pk = rs.getLong("id");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                LocalDate validade = rs.getDate("validade").toLocalDate();
                Categoria cat = Categoria.valueOf(rs.getString("categoria"));
                UnidadeMedida medida = UnidadeMedida.valueOf(rs.getString("unidade_medida"));

                Produto produto = new Produto();
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return produtos;
    }

    @Override
    public List<Produto> findByMed(UnidadeMedida medida) {
        String sql = "SELECT *FROM Produto WHERE categoria = ?";
        List <Produto> produtos = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, medida.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long pk = rs.getLong("id");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                LocalDate validade = rs.getDate("validade").toLocalDate();
                Categoria cat = Categoria.valueOf(rs.getString("categoria"));
                UnidadeMedida med = UnidadeMedida.valueOf(rs.getString("unidade_medida"));

                Produto produto = new Produto();
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return produtos;
    }
}
