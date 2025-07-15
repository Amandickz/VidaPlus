/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Amanda
 */
public class Leito {
    
    private int id;
    private int idAdministracao;
    private int tipoLeito;
    private int numero;
    private double valor;
    private int status;
    private int capacidade;
    private int internados;

    public Leito(int tipoLeito, int numero, double valor, int status, int capacidade, int internados) {
        this.tipoLeito = tipoLeito;
        this.numero = numero;
        this.valor = valor;
        this.status = status;
        this.capacidade = capacidade;
        this.internados = internados;
    }

    public Leito(int idAdministracao, int tipoLeito, int numero, double valor, int status, int capacidade, int internados) {
        this.idAdministracao = idAdministracao;
        this.tipoLeito = tipoLeito;
        this.numero = numero;
        this.valor = valor;
        this.status = status;
        this.capacidade = capacidade;
        this.internados = internados;
    }

    public Leito(int id, int idAdministracao, int tipoLeito, int numero, double valor, int status, int capacidade, int internados) {
        this.id = id;
        this.idAdministracao = idAdministracao;
        this.tipoLeito = tipoLeito;
        this.numero = numero;
        this.valor = valor;
        this.status = status;
        this.capacidade = capacidade;
        this.internados = internados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAdministracao() {
        return idAdministracao;
    }

    public void setIdAdministracao(int idAdministracao) {
        this.idAdministracao = idAdministracao;
    }

    public int getTipoLeito() {
        return tipoLeito;
    }

    public void setTipoLeito(int tipoLeito) {
        this.tipoLeito = tipoLeito;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getInternados() {
        return internados;
    }

    public void setInternados(int internados) {
        this.internados = internados;
    }

    @Override
    public String toString() {
        return "Leito{" + "id=" + id + ", idAdministracao=" + idAdministracao + ", tipoLeito=" + tipoLeito + ", numero=" + numero + ", valor=" + valor + ", status=" + status + ", capacidade=" + capacidade + ", internados=" + internados + '}';
    }
    
}
