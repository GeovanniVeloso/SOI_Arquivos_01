package view;

import java.io.IOException;

import controller.ArquivoController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		String path = "D:\\3 Semestre\\temp";
		String file = "generic_food.csv";
		
		IArquivosController arq = new ArquivoController();
		
		try {
			arq.readFile(path, file);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
