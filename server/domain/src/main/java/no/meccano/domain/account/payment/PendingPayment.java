package no.meccano.domain.account.payment;

import java.util.UUID;

public class PendingPayment
{
    private String id = UUID.randomUUID().toString().toUpperCase();
    private String kid;
    private String dueDate;
    private int amount;
    private String recipientNickname;
    private String recipientAccountNumber;

    public PendingPayment()
    {
    }

    public PendingPayment(final String kid, final String dueDate, final int amount, final String recipientAccountNumber, final String recipientNickname)
    {
        this.kid = kid;
        this.dueDate = dueDate;
        this.amount = amount;
        this.recipientAccountNumber = recipientAccountNumber;
        this.recipientNickname = recipientNickname;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getKid()
    {
        return kid;
    }

    public void setKid(final String kid)
    {
        this.kid = kid;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(final String dueDate)
    {
        this.dueDate = dueDate;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(final int amount)
    {
        this.amount = amount;
    }

    public String getRecipientNickname()
    {
        return recipientNickname;
    }

    public void setRecipientNickname(final String recipientNickname)
    {
        this.recipientNickname = recipientNickname;
    }

    public String getRecipientAccountNumber()
    {
        return recipientAccountNumber;
    }

    public void setRecipientAccountNumber(final String recipientAccountNumber)
    {
        this.recipientAccountNumber = recipientAccountNumber;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof PendingPayment))
        {
            return false;
        }

        final PendingPayment that = (PendingPayment) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "PendingPayment{" +
                "id='" + id + '\'' +
                ", kid='" + kid + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", amount=" + amount +
                ", recipientNickname='" + recipientNickname + '\'' +
                ", recipientAccountNumber='" + recipientAccountNumber + '\'' +
                '}';
    }
}
