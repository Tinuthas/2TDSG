package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.EstoqueBOStub;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProduto;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProdutoResponse;
import org.apache.ws.axis2.EstoqueBOStub.ProdutoTO;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Tela {

	protected Shell shlLojaFiapRun;
	private Table table;
	private Text txtTerminalDeConsulta;
	private Text text;

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
		
		table = new Table(shlLojaFiapRun, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(243, 70, 181, 146);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableItem item = new TableItem(table, 0);
		
		Button btnConsultar = new Button(shlLojaFiapRun, SWT.NONE);
		btnConsultar.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProdutoTO produto = null;
				try {
					
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultarProduto cp = new ConsultarProduto();
					cp.setCodigo(Integer.parseInt(text.getText()));
					ConsultarProdutoResponse response =  stub.consultarProduto(cp);
					produto = response.get_return();
					MessageDialog.openInformation(null, "SWT", produto.getDescricao());
					if(produto != null) 
					item.setText(new String[] {table.getItemCount()+"", produto.getDescricao()});
					
					produto = null;
				} catch (AxisFault ex) {
					MessageDialog.openInformation(null, "SWT", "Produto não Encontrado");
				} catch (RemoteException ex) {
					MessageDialog.openInformation(null, "SWT", "SIstema Fora do Ar");
				}
				
				
			}
		});
		btnConsultar.setBounds(27, 182, 181, 46);
		btnConsultar.setText("Consultar");
		
	
		
		
		
		
		
		Label lblTerminalDeConsulta = new Label(shlLojaFiapRun, SWT.NONE);
		lblTerminalDeConsulta.setBounds(27, 88, 188, 39);
		lblTerminalDeConsulta.setText("Digite o Codigo do Produto");
		
		txtTerminalDeConsulta = new Text(shlLojaFiapRun, SWT.BORDER);
		txtTerminalDeConsulta.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		txtTerminalDeConsulta.setText("Terminal de Consulta de Produtos");
		txtTerminalDeConsulta.setBounds(27, 25, 337, 39);
		
		text = new Text(shlLojaFiapRun, SWT.BORDER);
		text.setBounds(27, 140, 118, 21);

	}
	
	
}
