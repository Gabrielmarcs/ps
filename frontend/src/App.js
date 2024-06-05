import './App.css';
import Formulario from './Formulario';
import Informacao from './Informacao';

function App() {
  return (
    <div>
      <h1>Consulta de Benefícios</h1>
      <p>Consulta de benefício do Bolsa Família direcionado a um município</p>
      <Formulario/>
      <Informacao/>
    </div>
  );
}

export default App;
