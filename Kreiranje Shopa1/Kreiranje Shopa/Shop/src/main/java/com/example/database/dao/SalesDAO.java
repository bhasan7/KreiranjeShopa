package com.example.database.dao;

import com.example.database.JDBIManager;
import com.example.models.Buyer;
import com.example.models.Product;
import com.example.models.Sale;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SalesDAO {

    public static ArrayList<Sale> all() throws FileNotFoundException {
        String query_string = """
                SELECT sales.sales_id AS "sl_sales_id", sales.buyers_id AS "sl_buyers_id", 
                       sales.products_id AS "sl_products_id", sales.date_of_purchase AS "sl_date_of_purchase", 
                       buyers.buyers_id AS "by_buyers_id", 
                       buyers.name AS "by_name", 
                       buyers.surname AS "by_surname", buyers.email AS "by_email", 
                       buyers.packages AS "by_packages", products.products_id AS "pr_products_id", 
                       products.manufacturer AS "pr_manufacturer",products.name AS "pr_name",
                       products.price AS "pr_price" 
                FROM buyers, products, sales 
                WHERE (sales.buyers_id = buyers.buyers_id) 
                AND (sales.products_id = products.products_id) ;""";
        Jdbi jdbi = JDBIManager.get();
        List<Sale> result = jdbi.withHandle(handle -> {
            return new ArrayList<>(handle.createQuery(query_string)
                    .registerRowMapper(BeanMapper.factory(Buyer.class, "by"))
                    .registerRowMapper(BeanMapper.factory(Sale.class, "sl"))
                    .registerRowMapper(BeanMapper.factory(Product.class, "pr"))
                    .reduceRows(new LinkedHashMap<Long, Sale>(), (map, rowView) -> {
                        Sale sale = map.computeIfAbsent(rowView.getColumn("sl_sales_id", Long.class), id -> rowView.getRow(Sale.class));
                        if (rowView.getColumn("by_buyers_id", Long.class) != null) {
                            sale.setBuyers(rowView.getRow(Buyer.class));
                        }
                        if (rowView.getColumn("pr_products_id", Long.class) != null) {
                            sale.setProducts(rowView.getRow(Product.class));
                        }
                        return map;
                    }).values());
        });
        return (ArrayList<Sale>) result;
    }

    public static int save(int buyer_id,int product_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return  handle.createUpdate("INSERT INTO sales VALUES (NULL,:buyers_id,:products_id,CURRENT_DATE())").
                    bind("buyers_id",buyer_id).bind("products_id",product_id).execute();
        });
    }

    public static void delete(int sale_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM sales WHERE sales_id= :sale_id ")
                    .bind("sale_id",sale_id)
                    .execute();
        });
    }

    public static Sale get(int sales_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM sales WHERE sales_id= :sales_id")
                    .bind("sales_id",sales_id)
                    .mapToBean(Sale.class)
                    .one();
        });
    }

    public static void update(int buyer_id,int product_id,int sale_id) throws FileNotFoundException {
        Jdbi jdbi=JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                    UPDATE sales SET 
                    buyers_id= :buyer_id,
                    products_id= :product_id,
                    date_of_purchase=CURRENT_DATE()
                    WHERE sales_id= :sales_id""").
                    bind("buyer_id",buyer_id).
                    bind("product_id",product_id).
                    bind("sales_id",sale_id).execute();
        });
    }
}