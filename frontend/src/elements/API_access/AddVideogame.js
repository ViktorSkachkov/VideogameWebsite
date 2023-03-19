import axios from "axios";
import {useState} from "react";
import Cookies from "universal-cookie";

const AddVideogame = (loggedUser) => {
    const [image, setImage] = useState("image");
    const [name, setName] = useState("");
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState("");
    const [featured, setFeatured] = useState(false);

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    const onChangeDescription = event => {
        setDescription(event.target.value);
    }
    const onChangePrice = event => {
        setPrice(event.target.value);
    }
    const onChangeImage = event => {
        var reader = new FileReader();
        reader.onload = function (event) {
            setImage(event.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    const onChangeName = event => {
        setName(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "name": name,
            "price": price,
            "description": description,
            "featured": featured,
            "image": image,
        };
        axios.post(
            `http://localhost:8080/videogames`,
            bodyParams,
            config
        )
            .then(function (response) {
                alert('Videogame successfully added!');
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <>
            <center>
                <form onSubmit={handleSubmit}>
                    <br/><br/>
                    <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
                    <input type="file" name="image" onChange={onChangeImage} className="Label"/><br/><br/>
                    <label htmlFor="name" className="formLabelName">Name</label><br/>
                    <input type="text" name="name" onChange={onChangeName} value={name} className="Label" /><br/><br/>
                    <label htmlFor="username" className="formLabelDescription">Description</label><br/>
                    <textarea type="text" name="description" onChange={onChangeDescription} value={description} className="Label" /><br/><br/>
                    <label htmlFor="number" className="formLabelPrice">Price</label><br/>
                    <input type="number" name="price" onChange={onChangePrice} value={price} className="Label" /><br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}
export default AddVideogame;