import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Navigation from "./Navigation";
import Home from "./Home";
import Games from "./Games";
import Shop from "./Shop";
import News from "./News";
import Support from "./Support";
import Account from "./Account";
import Footer from "./Footer";
import {useState} from "react";
import ViewGame from "./ViewGame";
import ViewNewsArticle from "./ViewNewsArticle";
import Register from "./Register";
import LogIn from "./LogIn";
import ViewAddition from "./ViewAddition";
import UpdateVideogame from "./UpdateVideogame";
import UpdateAddition from "./UpdateAddition";
import UpdateNewsArticle from "./UpdateNewsArticle";
import AddVideogame from "./AddVideogame";
import AddAddition from "./AddAddition";
import AddNewsArticle from "./AddNewsArticle";
import Cookies from "universal-cookie";
import axios from "axios";
import jwtDecode from "jwt-decode";
import Profile from "./Profile";

function App() {
    const [loggedUser, setLoggedUser] = useState(null);
    const [expirationDate, setExpirationDate] = useState(null);

    const updateUser = () => {
        const cookies = new Cookies();
        const token = cookies.get("accessToken");
        console.log("token: " + token)
        var decode = jwtDecode(token);
        console.log(decode)
        const userID = decode.userId;
        console.log("userId: " + userID)

        var config = {
            method: "get",
            url: `http://localhost:8080/users/${userID}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };

        axios(config)
            .then(function (response) {
                const cookies = new Cookies();
                const token = cookies.get("accessToken");
                var decode = jwtDecode(token);
                setExpirationDate(decode.exp);
                setLoggedUser(response.data);
                let token_serialized = JSON.stringify(response.data);
                localStorage.setItem("token", token_serialized);
            })
            .catch(function (error) {
                console.log(error);
            });
        //this.location().reload();
    };
    const removeUser = () => {
        setLoggedUser(null);
        setExpirationDate(null);
        localStorage.removeItem("token");
    };

    /*const checkTokenExpiration = () => {
        if (expirationDate) {
            const currentTime = new Date().getTime() / 1000;
            if (currentTime > expirationDate) {
                removeUser();
            }
        }
    };*/


return (
    <>
    <Router>
        <Navigation
            removeUser={removeUser}
        />
        <Routes>
            <Route path="/" element={<Home /*loggedUser={loggedUser} */updateUser={updateUser} />}/>
            <Route path="/games" element={<Games loggedUser={loggedUser} />}/>
            <Route path="/shop" element={<Shop loggedUser={loggedUser} />}/>
            <Route path="/news" element={<News loggedUser={loggedUser} />}/>
            <Route path="/support" element={<Support loggedUser={loggedUser} />}/>
            <Route path="/register" element={<Register />}/>
            <Route path="/logIn" element={<LogIn updateUser={updateUser}/>}/>
            <Route path="/account/:id" element={<Account loggedUser={loggedUser} />}/>
            <Route path="/game/:id" element={<ViewGame loggedUser={loggedUser} />}/>
            <Route path="/addition/:id" element={<ViewAddition loggedUser={loggedUser} />}/>
            <Route path="/newsArticle/:id" element={<ViewNewsArticle loggedUser={loggedUser} />}/>
            <Route path="/profile/:id" element={<Profile removeUser={removeUser} updateUser={updateUser} />}/>
            <Route path="/updateVideogame/:id" element={<UpdateVideogame loggedUser={loggedUser} />}/>
            <Route path="/updateAddition/:id" element={<UpdateAddition loggedUser={loggedUser} />}/>
            <Route path="/updateNewsArticle/:id" element={<UpdateNewsArticle loggedUser={loggedUser} />}/>
            <Route path="/addVideogame" element={<AddVideogame loggedUser={loggedUser} />}/>
            <Route path="/addAddition" element={<AddAddition loggedUser={loggedUser} />}/>
            <Route path="/addNewsArticle" element={<AddNewsArticle loggedUser={loggedUser} />}/>
        </Routes>
    </Router>
    <Footer/>
    </>
)
}
export default App;