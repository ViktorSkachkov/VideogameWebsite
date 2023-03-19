import {useEffect, useState} from "react";
import axios from "axios";
import '../css/Shop.css';
import AdditionCard from "./AdditionCard";
import AdditionCardAdmin from "./AdditionCardAdmin";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";

const Shop = (loggedUser) => {
    const [additions, setAdditions] = useState([]);
    const [roles, setRoles] = useState([]);

    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getRoles();
        getAdditions();
    }, []);

    const getRoles = () => {
        let token_deserialized = JSON.parse(localStorage.getItem("token"));
        if(token_deserialized != null) {
            setRoles(token_deserialized.userRoles.map(element => element.role));
        }
    }

    const getAdditions = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/additions`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setAdditions(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    return (
        <>
            <center>
                <h1 className="title">ADDITIONS</h1>
                <h3 className="title">Filters</h3>
                {roles.some(r => r == "EMPLOYEE") ?
                    <> <div className="listOfAdditionsAdmin">
                        {
                            additions.map((addition) => (
                                <AdditionCardAdmin addition={addition}/>
                            ))
                        }
                    </div>
                        <button onClick={() => {
                            navigate(`/addAddition`, {
                            });
                        }}>Add Addition</button></>
                     : roles.some(r => r == "CUSTOMER") ?
                        <div className="listOfAdditions">
                        {
                            additions.map((addition) => (
                                <AdditionCard addition={addition}/>
                            ))
                        }
                    </div> : <></>
                }
            </center><br/>
        </>
    )
}
export default Shop;