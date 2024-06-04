export default function CalendarPopup({ data }) {
    const startTime = new Date(data.startDate);
    const endTime = new Date(data.endDate);

    const formattedStartTime = startTime.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    const formattedEndTime = endTime.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });

    return (
        <div className="flex flex-col">
            <div className="overflow-x-auto">
                <div className="inline-block min-w-full">
                    <div className="overflow-hidden">
                        <table className="min-w-full text-center">
                            <thead className="bg-white text-[#BDBDBD]">
                                <tr>
                                    <th scope="col" className="px-6 font-normal">Código</th>
                                    <th scope="col" className="px-6 font-normal">Curso</th>
                                    <th scope="col" className="px-6 font-normal">Hora</th>
                                    <th scope="col" className="px-6 font-normal">Aula</th>
                                    <th scope="col" className="px-6 font-normal">Docente</th>
                                    <th scope="col" className="px-6 font-normal">Modalidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr className="bg-neutral-100 text-[12px]">
                                    <td className="px-6 py-4">{data.code}</td>
                                    <td className="px-6 py-4">{data.title}</td>
                                    <td className="px-6 py-4">{formattedStartTime + "-" + formattedEndTime}</td>
                                    <td className="px-6 py-4">{data.room}</td>
                                    <td className="px-6 py-4">{data.teacher}</td>
                                    <td className="px-6 py-4">{data.type}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}