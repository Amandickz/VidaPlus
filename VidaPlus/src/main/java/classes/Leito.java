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
    private int tipoLeito;
    private int numero;
    private double valor;
    private int status;
    private int capacidade;

    public Leito(int tipoLeito, int numero, double valor, int status, int capacidade) {
        this.tipoLeito = tipoLeito;
        this.numero = numero;
        this.valor = valor;
        this.status = status;
        this.capacidade = capacidade;
    }

    public Leito(int id, int tipoLeito, int numero, double valor, int status, int capacidade) {
        this.id = id;
        this.tipoLeito = tipoLeito;
        this.numero = numero;
        this.valor = valor;
        this.status = status;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Leito{" + "id=" + id + ", tipoLeito=" + tipoLeito + ", numero=" + numero + ", valor=" + valor + ", status=" + status + ", capacidade=" + capacidade + '}';
    }
    
}
