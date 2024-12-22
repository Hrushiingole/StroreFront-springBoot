import React from 'react'

function CategoryFilter({categories,onselect}) {
  return (
    <>
    <select name="category" id="categorySelect" className='form-select' onChange={(e)=>onselect(e.target.value)} >
        <option value="">All Categories</option>
        {categories.map(category=>(
            <option key={category.id} value={category.id}>{category.name}</option>
        ))}

    </select>
    
    </>
  )
}

export default CategoryFilter