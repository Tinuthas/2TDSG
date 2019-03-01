package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Tela {

	protected Shell shlLojaFiapRun;
	private Table table;
	private Text txtTerminalDeConsulta;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLojaFiapRun.open();
		shlLojaFiapRun.layout();
		while (!shlLojaFiapRun.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLojaFiapRun = new Shell();
		shlLojaFiapRun.setSize(450, 300);
		shlLojaFiapRun.setText("Loja FIAP Run");
		
		Button btnConsultar = new Button(shlLojaFiapRun, SWT.NONE);
		btnConsultar.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MessageDialog.openInformation(null, "Mensagem", txtTerminalDeConsulta.getText());
				
			}
		});
		btnConsultar.setBounds(27, 180, 150, 48);
		btnConsultar.setText("Consultar");
		
		table = new Table(shlLojaFiapRun, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(243, 70, 181, 146);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Label lblTerminalDeConsulta = new Label(shlLojaFiapRun, SWT.NONE);
		lblTerminalDeConsulta.setBounds(32, 80, 188, 39);
		lblTerminalDeConsulta.setText("Terminal de Consulta de Produtos");
		
		txtTerminalDeConsulta = new Text(shlLojaFiapRun, SWT.BORDER);
		txtTerminalDeConsulta.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		txtTerminalDeConsulta.setText("Terminal de Consulta de Produtos");
		txtTerminalDeConsulta.setBounds(45, 25, 337, 39);

	}
}
