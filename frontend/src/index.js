import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './elements/API_access/App';
import reportWebVitals from './reportWebVitals';
import {Link, NavLink, BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Home from "./elements/API_access/Home";
import Games from "./elements/API_access/Games";
import Shop from "./elements/API_access/Shop";
import News from "./elements/API_access/News";
import Support from "./elements/API_access/Support";
import Account from "./elements/API_access/Account";
import Navigation from "./elements/API_access/Navigation";
import Footer from "./elements/API_access/Footer";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
          <App/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
