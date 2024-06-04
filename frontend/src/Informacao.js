import React from 'react';

function Informacao({ dados }) {
    if (!Array.isArray(dados)) {
        return null;
    }

    return (
        <table className="table">
            <thead>
                <tr>
                    <th>Município</th>
                    <th>N° de Pessoas Beneficiadas</th>
                    <th>Valor Total</th>
                </tr>
            </thead>
            <tbody>
                {dados.map((item, index) => (
                    <tr key={index}>
                        <td>{item.municipio.nomeIBGE}</td>
                        <td>{item.quantidadeBeneficiados}</td>
                        <td>{item.valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default Informacao;
