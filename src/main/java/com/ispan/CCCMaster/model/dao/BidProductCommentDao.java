package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidProductCommentDao extends JpaRepository<BidProductComment, Integer> {

    @Query("FROM BidProductComment b WHERE b.bidProduct = :bidProduct")
    Page<BidProductComment> findAllByBidProduct(@Param("bidProduct") BidProduct bidProduct, Pageable pageable);
}
