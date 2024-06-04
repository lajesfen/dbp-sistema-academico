export default function InfoElement({ title, value }) {
    return (
        <div className="text-[12px]">
            <h3 className="font-bold">{title}</h3>
            <p>{value}</p>
        </div>
    );
}