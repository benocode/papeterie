package fr.eni.papeterie.app.swing.ecrCatalogue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Stylo;

public class TableCatalogueModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Article> catalogue;

	private String[] columnNames = { "", "Référence", "Marque", "Désignation", "Prix unitaire", "Stock" };

	public TableCatalogueModel(List<Article> catalogue) {
		this.catalogue = catalogue;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return catalogue.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		switch (columnIndex) {
		case TableCatalogue.COL_ICON:
			val = catalogue.get(rowIndex) instanceof Stylo ? "S" : "R";
			break;
		case TableCatalogue.COL_REFERENCE:
			val = catalogue.get(rowIndex).getReference();
			break;
		case TableCatalogue.COL_MARQUE:
			val = catalogue.get(rowIndex).getMarque();
			break;
		case TableCatalogue.COL_DESIGNATION:
			val = catalogue.get(rowIndex).getDesignation();
			break;
		case TableCatalogue.COL_PU:
			val = catalogue.get(rowIndex).getPrixUnitaire();
			break;
		case TableCatalogue.COL_STOCK:
			val = catalogue.get(rowIndex).getQteStock();
			break;
		}
		return val;
	}
}
