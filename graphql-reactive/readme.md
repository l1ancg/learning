
#### 简单查询
```graphql
{
  customers{
    id, name, __typename
  }
}
```

#### 关联查询
```graphql
{
  customers{
    id
    name
    orders {
      id
      customerId
    }
    __typename
  }
}
```

#### 条件查询
```graphql
{
  customersByName(name: "Aa") {
    id, name, __typename, orders {id,customerId}
  }
}
```

插入数据
```graphql
mutation {
    addCustomer(id: 5, name: "Ee") {
        id, name, orders { id, customerId }
    }
}
```