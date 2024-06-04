function Formulario() {

    return (
        <form>
            <input type="text" name="codIbge" placeholder='código ibge'/>
            <input type="month" name="data" placeholder='mes-ano'/>

            <input type="button" value="Consultar"/>
        </form>
    )
}

export default Formulario;