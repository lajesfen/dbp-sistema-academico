import { PiGraduationCapLight } from 'react-icons/pi';
import PaymentElement from './PaymentElement';

export default function Payments({ userData }) {
    return (
        <div className="flex flex-col h-[45vh] max-h-[700px] w-[50vw] max-w-2xl bg-white shadow-md rounded-lg px-6 py-4">
            <div className='flex text-[13px] pb-3 items-center font-medium'>
                <PiGraduationCapLight size={18} className='mr-1' />
                Obligaciones Pendientes
            </div>
            <hr />
            <div>
                {userData.payments ? userData.payments.map((data) => (
                    <PaymentElement data={data} key={data.id}/>
                )) : <p className='mt-4 text-center text-[13px] text-[#BDBDBD]'>No se ha encontrado información del usuario.</p>}
            </div>
        </div>
    );
}