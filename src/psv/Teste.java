package psv;

import java.sql.*;
import java.util.*;

public class Teste {

    public static void main(String[] args) {
        Connection con = Conexao.abrirConexão();

        CarroBean cb = new CarroBean();

        CarroDAO cd = new CarroDAO(con);

        cb.setPlaca("FIY8362");
        cb.setCor("Preto");
        cb.setDescricao("ix35, 2015");

        System.out.println(cd.inserir(cb));

        List<CarroBean> lista = cd.listarTodos();

        if (lista != null) {
            for (CarroBean carro : lista) {
                System.out.println("Placa: " + carro.getPlaca());

                System.out.println("Cor: " + carro.getCor());

                System.out.println("Descrição: " + carro.getDescricao());
            }
        }
        Conexao.fecharConexão(con);
    }
}
