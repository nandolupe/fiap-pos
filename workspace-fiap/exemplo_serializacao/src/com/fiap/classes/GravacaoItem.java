package com.fiap.classes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GravacaoItem {
	public static void main(String[] args) {
		
		Item item = new Item();
		item.setCodigo(12331);
		item.setDescricao("TESTE");
	
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("C:/Exercicios/dados.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(item);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Objeto Gravado!");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
