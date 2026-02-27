import Menu from "./Menu";

export default function Layout({ children }) {
  return (
    <div style={{ display: "flex" }}>
      <Menu />
      <div style={{ padding: 20, width: "100%" }}>
        {children}
      </div>
    </div>
  );
}