package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController killController = new KillController(); 
		int opc = 0;
        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite o processo que voce deseja\n1 - Listar Processos\n2 - Matar por PID\n3 - Matar por Nome\n9 - Finalizar"));
            switch(opc) {
                case 1: 
                    killController.listaProcessos();
                    break;
                case 2:
                    int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
                    killController.mataPid(pid);
                    break;
                case 3:
                    String nome = JOptionPane.showInputDialog("Digite o nome: ");
                    killController.mataNome(nome);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida");
            }
        }
	}

}