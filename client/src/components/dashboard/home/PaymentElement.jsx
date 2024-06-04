export default function PaymentElement({ data }) {
    return (
        <div className="flex flex-row rounded-lg shadow my-3 justify-between px-3 py-2">
            <div>
                <p className="font-medium text-[12px]">
                    {data.description}
                </p>
                <p className="text-[#BDBDBD] text-[11px]">
                    {new Date(data.due_date).toLocaleDateString('es-MX')}
                </p>
            </div>
            <div className="flex items-center text-[12px]">
                S./ {data.amount}
            </div>
        </div>
    );
}