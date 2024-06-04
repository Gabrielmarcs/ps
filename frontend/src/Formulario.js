function Formulario() {

    return (
        <form>
            <input type="text" placeholder='código ibge' className='form-control'/>
            <input type="month" placeholder='mês-ano' className='form-control'/>

            <input type="button" value="Consultar" className='btn btn-primary'/>
        </form>
    )
}

export default Formulario;