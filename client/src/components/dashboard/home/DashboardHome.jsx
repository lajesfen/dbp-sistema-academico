import PageButton from './PageButton';
import Calendar from './Calendar';
import Payments from './Payments';
import dashboardHeader from '../../../assets/dashboard-header.png'

export default function DashboardHome({ userData }) {
  return (
    <div className='m-9'>
      <div className='flex flex-col max-w-7xl'>
        <img src={dashboardHeader} alt='UTEC Header'></img>
      </div>
      <div className='flex space-x-4 mt-7'>
        <PageButton text={"Canvas"} iconid={0} url={"https://utec.instructure.com/"}/>
        <PageButton text={"Consulta de Trámites"} iconid={1} url={"https://solicitud-intranet.utec.edu.pe/"}/>
        <PageButton text={"Encuestas"} iconid={2} url={"https://encuestas.utec.edu.pe/"}/>
        <PageButton text={"Matrícula en Linea"} iconid={3} url={"https://matricula.utec.edu.pe/"}/>
        <PageButton text={"Premátricula en Linea"} iconid={4} url={"https://prematricula.utec.edu.pe/"}/>
        <PageButton text={"Reserva de Ambientes"} iconid={5} url={"https://reserva-intranet.utec.edu.pe/"}/>
      </div>
      <div className='flex space-x-4 mt-7'>
        <Calendar userData={userData} />
        <Payments userData={userData}/>
      </div>
    </div>
  );
}