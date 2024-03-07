package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	public void listaProcessos() {
		String os = os();
		if (os.contains("Windows")) {
			String windows = "TASKLIST /FO TABLE";
			try {
				Process pwindows = Runtime.getRuntime().exec(windows);
				InputStream fluxowindows = pwindows.getInputStream();
				InputStreamReader leitorwindows = new InputStreamReader(fluxowindows);
				BufferedReader bufferwindows = new BufferedReader(leitorwindows);
				String linhawindows = bufferwindows.readLine();
				while (linhawindows != null) {
					System.out.println(linhawindows);
					linhawindows = bufferwindows.readLine();
				}
				bufferwindows.close();
				leitorwindows.close();
				fluxowindows.close();
			} catch (Exception e) {

			}
		} else {
			String linux = "ps -ef";
			try {
				Process plinux = Runtime.getRuntime().exec(linux);
				InputStream fluxolinux = plinux.getInputStream();
				InputStreamReader leitorlinux = new InputStreamReader(fluxolinux);
				BufferedReader bufferlinux = new BufferedReader(leitorlinux);
				String linhalinux = bufferlinux.readLine();
				while (linhalinux != null) {
					System.out.println(linhalinux);
					}
				}catch (IOException e) {
			}
		}
	}
	public void mataPid(int pid) { 
		String os = os();
		if(os.contains("Windows")) {
			String pidWindows = "TASKKILL /PID";
			StringBuffer bufferWindows = new StringBuffer();
			bufferWindows.append(pidWindows);
			bufferWindows.append(" ");
			bufferWindows.append(pid);
			try {
				Runtime.getRuntime().exec(bufferWindows.toString());
			} catch (IOException e) {
			}
		}else {
			String pidLinux = "kill -9";
			StringBuffer bufferLinux = new StringBuffer();
			bufferLinux.append(pidLinux);
			bufferLinux.append(" ");
			bufferLinux.append(pid);
			try {
				Runtime.getRuntime().exec(bufferLinux.toString());
			} catch (IOException e) {
			}
		}
	}
	public void mataNome(String nome) {
		String os = os();
		if(os.contains("Windows")) {
			String pidWindows = "TASKKILL /IM";
			StringBuffer bufferWindows = new StringBuffer();
			bufferWindows.append(pidWindows);
			bufferWindows.append(" ");
			bufferWindows.append(nome);
			try {
				Runtime.getRuntime().exec(bufferWindows.toString());
			} catch (IOException e) {
			}
		}else {
			String pidLinux = "pkill -f";
			StringBuffer bufferLinux = new StringBuffer();
			bufferLinux.append(pidLinux);
			bufferLinux.append(" ");
			bufferLinux.append(nome);
			try {
				Runtime.getRuntime().exec(bufferLinux.toString());
			} catch (IOException e) {
			}
		}		
	}
}