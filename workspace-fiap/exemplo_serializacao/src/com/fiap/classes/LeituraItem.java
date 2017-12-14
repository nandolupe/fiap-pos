package com.fiap.classes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LeituraItem {

	public static void main(String[] args) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("C:/Exercicios/dados.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			Item item = (Item) objectInputStream.readObject();
			
			System.out.println("Codigo: " + item.getCodigo());
			System.out.println("Descrição: " + item.getDescricao());
			
			objectInputStream.close();
			fileInputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
