package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{
	
	private int idCarro;
	private Semaphore mutex;
	

	public ThreadCruzamento(int idCarro, Semaphore mutex) {
		this.idCarro = idCarro;
		this.mutex = mutex;
	}
	
	@Override
	public void run() {
		andando();
		try {
			mutex.acquire();
			Cruzamento();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
		
	}

	private void andando() {
		int distanciaSemaforo = 100;
		int percorrido = 0;
		int deslocamento = (int) (Math.random() * 50) + 1;
		
		while(percorrido < distanciaSemaforo) {
			percorrido += deslocamento;
//			int tempo = 100;
//			try {
//				sleep(tempo);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("O carro " + idCarro + " andou " + percorrido + " metros");
		}
		System.out.println("O carro " + idCarro + " chegou ao cruzamento");
	}

	private void Cruzamento() {
		
		if(idCarro == 0) {
			System.out.println("O carro " + idCarro + " foi de Norte a Sul");
		}
		if(idCarro == 1) {
			System.out.println("O carro " + idCarro + " foi de Sul a Norte");
		}
		if(idCarro == 2) {
			System.out.println("O carro " + idCarro + " foi de Leste a Oeste");
		}
		if(idCarro == 3) {
			System.out.println("O carro " + idCarro + " foi de Oeste a Leste");
		}
		
	}
	
	
}
