import {useEffect, useState} from "react";
import axios from "axios";
import '../css/Games.css';
import VideogameCard from "./VideogameCard";
import VideogameCardAdmin from "./VideogameCardAdmin";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";

const Games = (loggedUser) => {
    const [videogames, setVideogames] = useState([]);
    const [roles, setRoles] = useState([]);

    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getRoles();
        getVideogames();
    }, []);

    const getRoles = () => {
        let token_deserialized = JSON.parse(localStorage.getItem("token"));
        if(token_deserialized != null) {
            setRoles(token_deserialized.userRoles.map(element => element.role));
        }
    }
    const getVideogames = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/videogames`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setVideogames(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <>
            <center>
                <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
                <h1 className="title">GAMES</h1>
                <h3 className="title">Filters</h3>
            </center>
            {roles.some(r => r == "EMPLOYEE") ?
                <center>
                    <div className="listOfGamesAdmin">
                        {videogames.map((videogame) => (
                            <VideogameCardAdmin videogame={videogame} />
                        ))}
                    </div>
                    <button onClick={() => {
                        navigate(`/addVideogame`, {
                        });
                    }}>Add Game</button>
                </center> :  roles.some(r => r == "CUSTOMER") ?
                <div className="listOfGames">
                    {videogames.map((videogame) => (
                        <VideogameCard videogame={videogame} />
                    ))}
                </div> : <></>}
                    <br/>
        </>
    )
}
export default Games;