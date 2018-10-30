package com.nuevatel.crm.sensor.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import com.nuevatel.crm.sensor.sftp.SFtp;

public class UnZip implements IUnZip {
	private static Log log;

	public UnZip() {
		log = LogFactory.getLog(UnZip.class);
	}

	@Override
	public void unZip(String fileName, String outDirectory) throws Exception {
			log.debug("Descomprimiendo nel archivo "+fileName);		       
		    final int TAM_BUFFER = 4096;
		    byte[] buffer = new byte[TAM_BUFFER];

		    ZipInputStream flujo = null;
		    try {
		      flujo = new ZipInputStream(new BufferedInputStream(
		              new FileInputStream(fileName)));
		      ZipEntry entrada;
		      while ((entrada = flujo.getNextEntry()) != null) {
		        String nombreSalida = outDirectory + File.separator
		                + entrada.getName();
		        if (entrada.isDirectory()) {
		          File directorio = new File(nombreSalida);
		          directorio.mkdir();
		        } else {
		          BufferedOutputStream salida = null;
		          try {
		            int leido;
		            salida = new BufferedOutputStream(
		                    new FileOutputStream(nombreSalida), TAM_BUFFER);
		            while ((leido = flujo.read(buffer, 0, TAM_BUFFER)) != -1) {
		              salida.write(buffer, 0, leido);
		            }
		          }catch (Exception e) {
				    	log.error("FileUnzip ",e);
				    } finally {
		            if (salida != null) {
		              salida.close();
		            }
		          }
		        }
		      }
		    }catch (Exception e) {
		    	log.error("Unzip ",e);
		    } finally {
		      if (flujo != null) {
		        flujo.close();
		      }

		    }
		 }
	}

