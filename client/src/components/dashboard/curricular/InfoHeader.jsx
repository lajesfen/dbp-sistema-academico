import InfoElement from "./InfoElement";

export default function InfoHeader({ userData }) {
    return (
        <div className="flex items-center">
            <div className="w-[130px] flex align-middle justify-center rounded-2xl overflow-hidden">
                <img className='h-[100%] w-[100%] object-cover'
                    src={userData.avatar_url}
                />
            </div>
            <div className="flex m-4 ml-6 flex-row space-x-14">
                <div className="flex flex-col space-y-5">
                    <InfoElement title="Nombre del alumno:" value={userData.name} />
                    <InfoElement title="Código:" value={userData.id} />
                </div>
                <div className="flex flex-col space-y-5">
                    <InfoElement title="Periodo de ingreso:" value={userData.entry_period} />
                    <InfoElement title="Orden de mérito:" value={userData.merit_order} />
                </div>
                <div className="flex flex-col space-y-5">
                    <InfoElement title="Programa:" value={userData.program} />
                    <InfoElement title="Promedio ponderado:" value={userData.weighted_average} />
                </div>
                <div className="flex flex-col space-y-5">
                    <InfoElement title="Carrera:" value={userData.carreer} />
                    <div className="flex flex-row space-x-14">
                        <InfoElement title="Orden de mérito de la carrera:" value={userData.carreer_merit_order} />
                        <InfoElement title="Condición PCE:" value={userData.pce ? "Si" : "No"} />
                    </div>
                </div>
            </div>
        </div>
    );
}
