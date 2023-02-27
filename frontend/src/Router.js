import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./modules/Login/Login";

import Manager from "./modules/Manager/container/Manager";
import Employee from "./modules/Employee/container/Employee";

function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Login />} />

        <Route path="/employee" element={<Employee />} />
        <Route path="/manager" element={<Manager />} />

        {/* <Route path="/toemp" element={<Managertoemp />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
