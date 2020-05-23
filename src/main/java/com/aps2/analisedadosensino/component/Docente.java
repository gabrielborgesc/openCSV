package com.aps2.analisedadosensino.component;

import com.aps2.analisedadosensino.NomeDisciplina;
import com.aps2.analisedadosensino.leaf.Nivel;

// Component - Composite
// Product - Fábrica
public interface Docente {
	Nivel getNivel();

	NomeDisciplina getNomeDisciplina();

	String analisa();
}
