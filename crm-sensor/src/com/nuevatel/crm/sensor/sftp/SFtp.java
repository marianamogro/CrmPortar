package com.nuevatel.crm.sensor.sftp;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.nuevatel.crm.sensor.config.Configuration;
import com.nuevatel.crm.sensor.csv.Csv;
import com.nuevatel.crm.sensor.integration.WebPushOneSignal;
import com.nuevatel.crm.sensor.port.dao.CashBoxProcessDao;
import com.nuevatel.crm.sensor.util.Util;
import com.nuevatel.crm.sensor.zip.UnZip;

public class SFtp implements ISftp {
	private static final String USERNAME = "us_prog";
	private static final String HOST = "localhost";
	private static final int PORT = 22;
	private static final String PASSWORD = "programac";
	
	private static Log log;

	public SFtp() {
		log = LogFactory.getLog(SFtp.class);
	}

	/**
	 * Sesion SFTP establecida.
	 */
	private Session session;

	/**
	 * Establece una conexion SFTP.
	 *
	 * @param username Nombre de usuario.
	 * @param password Contrasena.
	 * @param host     Host a conectar.
	 * @param port     Puerto del Host.
	 *
	 * @throws JSchException          Cualquier error al establecer conexión SFTP.
	 * @throws IllegalAccessException Indica que ya existe una conexion SFTP
	 *                                establecida.
	 */
	public void connect(String username, String password, String host, int port)
			throws JSchException, IllegalAccessException {
		if (this.session == null || !this.session.isConnected()) {
			JSch jsch = new JSch();

			this.session = jsch.getSession(username, host, port);
			this.session.setPassword(password);

			// Parametro para no validar key de conexion.
			this.session.setConfig("StrictHostKeyChecking", "no");

			this.session.connect();
		} else {
			throw new IllegalAccessException("Sesion SFTP ya iniciada.");
		}
	}

	@Override
	public String getFile(String externalFileName, String localFileName) {
		try {
			// session = jsch.getSession("admin", "127.0.0.1", 22);
			log.debug("Iniciando la descarga del archivo ftp......................");
			connect("vivaftp", "ViVamas.751", "200.105.170.116", 5894);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword("pass");
			// session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			// sftpChannel.get("/daily/npc_daily_portings_and_returns_2018-10-19.zip",
			// "./ftp/npc_daily_portings_and_returns_2018-10-19.zip");
			sftpChannel.get(externalFileName, localFileName);
			sftpChannel.exit();
			session.disconnect();
			System.out.println("Termino");
		} catch (JSchException e) {
			log.error("get file 1: ",e);
			 WebPushOneSignal.sendWebPushMessage("Fallo descarga Ftp");
		} catch (SftpException e) {
			log.error("get file 2: ",e);
			 WebPushOneSignal.sendWebPushMessage("Fallo descarga Ftp");
		} catch (Exception e) {
			log.error("get file 3: ",e);
			 WebPushOneSignal.sendWebPushMessage("Fallo descarga Ftp");
		} finally {
			if (session.isConnected()) {
				session.disconnect();
			}

		}
		return null;
	}

	@Override
	public String putFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void downloadSftp() {
		try {
			String dirLocal = null;
			String dirLocalCsv = null;
			String dirExtern = null;
			Configuration.loadProperties();
			dirLocalCsv= Configuration.ftpDirLocal+Util.sysdate()+".csv";
			dirLocal= Configuration.ftpDirLocal+Util.sysdate()+".zip";
			dirExtern= Configuration.ftpDirExtern+Util.sysdate()+".zip";
			
			/*System.out.println(Util.sysdate());*/
			
			System.out.println(dirLocal);
			System.out.println(dirExtern);
			System.out.println(dirLocalCsv);
			
			getFile(dirExtern,	dirLocal);

			UnZip unZip = new UnZip();
			unZip.unZip(dirLocal, "./ftp");

			Csv csv = new Csv();
			Integer counter = csv.countCsvRows(dirLocalCsv);
			counter = counter - 1;
			System.out.println("Terminso " + counter);
		} catch (Exception ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {

		try {
			DOMConfigurator.configure("log4jLog.xml");
			SFtp sshConnector = new SFtp();
			sshConnector.downloadSftp();
			
			

		} catch (Exception ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		}
	}
}
