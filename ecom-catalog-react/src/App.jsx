
import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
  
  const [products,setProducts]=useState([]);

  useEffect(()=>{
      fetch('http://localhost:8080/api/product')
      .then(response=> response.json())
      .then(data => setProducts(data));
      console.log(products);
  },[]);

  return (
    <>
      <div className='container'>
        <div>
          {products.length ? (
            //display products
            <ProductList products={products} />
          ): (
            <p>No products found</p>
          )}
        </div>
      </div>
    </>
  )
}

export default App
