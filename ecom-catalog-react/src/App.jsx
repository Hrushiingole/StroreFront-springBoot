
import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  
  const [products,setProducts]=useState([]);
  const [categories,setCategories]=useState([]);
  const [selectedCategory,setSelectedCategory]=useState(null);
  const [searchTerm,setSearchTerm]=useState("");
  const [sortOrder,setSortOrder]=useState("asc");


  useEffect(()=>{
      fetch('http://localhost:8080/api/product')
      .then(response=> response.json())
      .then(data => setProducts(data));

      // console.log(products)
      fetch('http://localhost:8080/api/categories')
      .then(response=> response.json())
      .then(data => setCategories(data));
      // console.log(categories);
  },[]);

  const handleCategorySelect=(categoryId)=>{
    setSelectedCategory(categoryId ? Number(categoryId) : null);
    // console.log(selectedCategory);
  }

  
   const categoryObj=categories.find(category=>category.id===selectedCategory);
   const filteredProducts=categoryObj ? categoryObj.products : products;
  // console.log(products);
  // console.log(selectedCategory);
  // console.log(categories);
  if(!products.length){
    return (
      <div className='container'>
        <h1 className='my-4'>Product catalog</h1>
        <p>Loading products...</p>
      </div>
    )
  }
  return (
    <>
      <div className='container'>
        <h1 className='my-4'>Product catalog</h1>
        <div className='row align-items-center mb-4'>
            <div className='col-md-3 col-sm-12 mb-2'>
                <CategoryFilter categories={categories} onselect={handleCategorySelect}/>

            </div>
            <div className='col-md-5 col-sm-12 mb-2'>
                <input type="text" placeholder='Search for a product' value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} className='form-control'/>
            </div>
            <div className='col-md-4 col-sm-12 mb-2'>
                <select className='form-select' value={sortOrder} onChange={(e) => setSortOrder(e.target.value)}>
                    <option value="asc">Price: Low to High</option>
                    <option value="desc">Price: High to Low</option>
                </select>
            </div>
        </div>
        <div>
          {filteredProducts.length ? (
            //display products
            <ProductList products={filteredProducts} />
          ): (
            <p>No products found</p>
          )}
        </div>
      </div>
    </>
  )
}

export default App
