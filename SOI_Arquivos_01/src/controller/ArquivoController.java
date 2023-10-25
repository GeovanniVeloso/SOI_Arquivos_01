package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoController implements IArquivosController {

	public ArquivoController() {
		super();
	}

	@Override
	public void readFile(String path, String file) throws IOException {
		File arq = new File(path, file);
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream flux = new FileInputStream(arq);
				InputStreamReader reader = new InputStreamReader(flux);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				String[] vet = linha.split(",");
				System.out.println(vet[0] + "     " + vet[1] + "     " + vet[2]);
				while (linha != null) {
					String[] vet2 = linha.split(",");
					if (vet2[2].contains("Fruits")) {
						System.out.println(vet2[0] + "     " + vet2[1] + "     " + vet2[3]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				reader.close();
				flux.close();
			} else {
				throw new IOException("Arquivo Inválido");
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

}
