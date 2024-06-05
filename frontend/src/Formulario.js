import React, { useState } from 'react';
import axios from 'axios';
import Informacao from './Informacao';

function Formulario() {
    const [codIbge, setCodIbge] = useState('');
    const [mesAno, setMesAno] = useState('');
    const [dados, setDados] = useState([]);
    const [erroConsulta, setErroConsulta] = useState('');

    const handleCodIbgeChange = (e) => {
        const v = e.target.value;
        const regex = /^\d*$/;

        if (regex.test(v)) {
            setCodIbge(v);
        }
    };

    const handleMesAnoChange = (e) => {
        const value = e.target.value;
        const regex = /^(\d{0,2})(\/)?(\d{0,4})$/;

        if (regex.test(value)) {
            const formattedValue = value.replace(/^(\d{2})(\d{0,4})$/, '$1/$2');
            setMesAno(formattedValue);
        }
    };

    const formatar = (mesAno) => {
        const [mes, ano] = mesAno.split('/');
        return ano + mes;
    };

    const consultar = () => {
        axios.get(`http://localhost:8080/api/consulta/beneficios?mesAno=${formatar(mesAno)}&codIbge=${codIbge}`)
            .then(response => {
                console.log('Dados recebidos da API:', response.data);
                setDados(response.data);
                setErroConsulta('');
            })
            .catch(error => {
                console.error('Erro ao consultar os dados', error);
                setDados([]);
                setErroConsulta('Erro ao realizar a consulta. Por favor, tente novamente.');
            });
    };

    const recarregarPagina = () => {
        window.location.reload();
    };

    return (
        <div>
            {erroConsulta && (
                <div className="alert alert-danger" role="alert">
                    {erroConsulta}
                    <button className="btn btn-primary ml-3" onClick={recarregarPagina}>Ok</button>
                </div>
            )}
            <form>
                <div className="form-group">
                    <label htmlFor="codIbge">Código IBGE da Cidade:</label>
                    <input
                        type="text"
                        id="codIbge"
                        className="form-control"
                        placeholder='Código IBGE'
                        value={codIbge}
                        onChange={handleCodIbgeChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="mesAno">Mês e Ano de Referência:</label>
                    <input
                        type="text"
                        id="mesAno"
                        className="form-control"
                        placeholder="MM/AAAA"
                        value={mesAno}
                        onChange={handleMesAnoChange}
                        maxLength="7"
                    />
                </div>
                <input
                    type="button"
                    value="Consultar"
                    className="btn btn-primary"
                    onClick={consultar}
                />
            </form>
            {dados.length > 0 && <Informacao dados={dados} />}
        </div>
    );
}

export default Formulario;